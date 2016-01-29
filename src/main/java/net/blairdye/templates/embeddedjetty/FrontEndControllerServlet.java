package net.blairdye.templates.embeddedjetty;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.TransformerException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class FrontEndControllerServlet extends HttpServlet {
	private static final Logger logger = Logger.getLogger(FrontEndControllerServlet.class);
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
		try {
			doIt(req, resp);
		} catch (final IOException e) {
			throw e;
		} catch (final Exception e) {
			throw new ServletException(e);
		}
	}

	private void doIt(final HttpServletRequest req, final HttpServletResponse resp) throws TransformerException,
			ServletException,IOException {
		if(StringUtils.isNotBlank(req.getParameter("show"))){
			req.getRequestDispatcher("/jsp/basicresponse.jsp").forward(req, resp);
		}else if(StringUtils.isNotBlank(req.getParameter("submit"))){
			//just an example of different submit buttons 
			final String testName = req.getParameter("testName");
			logger.debug("Received submitted issuer "+testName);
			req.getRequestDispatcher("/jsp/processedresponse.jsp").forward(req, resp);
		}
	}
}
