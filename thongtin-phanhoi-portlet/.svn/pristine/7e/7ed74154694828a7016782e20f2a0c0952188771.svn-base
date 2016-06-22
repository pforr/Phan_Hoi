package vn.dtt.ns.reporting;

import java.io.IOException;
import java.util.ArrayList;

import javax.portlet.PortletException;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

public class ObjectExportToReportUtils {
	
	public static <T>JRBeanCollectionDataSource exportBieuMau( T object) throws PortalException, SystemException, IOException, PortletException {
		ArrayList<T> dataBeanList = getDataReport( object);
		
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
		return beanColDataSource;
	}
	public static <T> ArrayList<T> getDataReport ( T object) throws PortalException, SystemException{
		ArrayList<T> dataBeanList = new ArrayList<T>();
		dataBeanList.add(getModel( object));
		return dataBeanList;
	}
	
	public static <T> T getModel( T object) throws PortalException, SystemException {
		return object;
	}

}
