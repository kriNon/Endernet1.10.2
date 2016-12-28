package kriNon.endernet.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kriNon.endernet.Reference;

public class Utils {

		private static Logger logger;
		
		public static Logger getLogger() {
			if(logger == null) {
				logger = LogManager.getFormatterLogger(Reference.MODID);
			}
			return logger;
		}
}
