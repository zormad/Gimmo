/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.utils.JSFUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.faces.context.FacesContext;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author ZORE
 */
public class AbstractBean {

    public AbstractBean() {
    }

    protected void displayInfoMessage(String message) {
        JSFUtils fUtils = new JSFUtils();
        fUtils.sendInfoMessage(message);
    }

    protected void displayErrorMessage(String message) {
        JSFUtils fUtils = new JSFUtils();
        fUtils.sendInfoMessage(message);
    }

    public void PDF2(Map<String, Object> params, String jasperPath, String sql, String chemin, String filename, Connection conn) throws JRException, IOException {

        try {
//            String relativeWebPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(jasperPath);
//            File file = new File(relativeWebPath);
//            // - Chargement et compilation du rapport
//            JasperDesign jasperDesign = JRXmlLoader.load(file.getPath());
//            //JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//            JRDesignQuery newQuery = new JRDesignQuery();
//            newQuery.setText(sql);
//            jasperDesign.setQuery(newQuery);
//            JasperReport jr = JasperCompileManager.compileReport(jasperDesign);
//
//            //JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(datasource, false);
//            //JasperPrint print = JasperFillManager.fillReport(file.getPath(), params, new JREmptyDataSource());
//            // - Execution du rapport
//            JasperPrint print = JasperFillManager.fillReport(jr, params, conn);
//            JasperExportManager.exportReportToPdfFile(print, chemin + filename);
//            JasperViewer.viewReport(print);
//
////        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
////        response.addHeader("Context-disposition", "attacement;filename=" + filename);
////        ServletOutputStream stream = response.getOutputStream();
////        JasperExportManager.exportReportToPdfStream(print, stream);
////        FacesContext.getCurrentInstance().responseComplete();
            String relativeWebPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(jasperPath);
            File file = new File(relativeWebPath);
            //JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(datasource, false);
            JasperDesign jasperDesign = JRXmlLoader.load(file.getPath());
            //JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint print = JasperFillManager.fillReport(file.getPath(), params, conn);
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            response.addHeader("Context-disposition", "attacement;filename=" + filename);
            ServletOutputStream stream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(print, stream);
            FacesContext.getCurrentInstance().responseComplete();
        } catch (JRException e) {
            displayErrorMessage("erreur lors de l'impression du fichier");
        }
    }

    public void PDF(Map<String, Object> params, String jasperPath, List<?> datasource, String filename) throws JRException, IOException {
        String relativeWebPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(jasperPath);
        File file = new File(relativeWebPath);
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(datasource, false);
        System.out.println("" + file.getPath());
        JasperPrint print = JasperFillManager.fillReport(file.getPath(), params, beanCollectionDataSource);
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Context-disposition", "attacement;filename=" + filename);
        ServletOutputStream stream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(print, stream);
        FacesContext.getCurrentInstance().responseComplete();

    }

    public void report(Map<String, Object> params, String report, String sql, String chemin, String title, Connection conn) throws IOException, JRException {
        if (conn != null) {
            try {

                //BasicConfigurator.configure();
                String lieuFichier = report;//"/report/"+report;
                String rech = FacesContext.getCurrentInstance().getExternalContext().getRealPath(lieuFichier);
                File file = new File(rech);
                JasperDesign jd = JRXmlLoader.load(file.getPath());
                JRDesignQuery newQuery = new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);
                JasperReport jr = JasperCompileManager.compileReport(jd);
                JasperPrint jp = JasperFillManager.fillReport(jr, params, conn);
                //JasperExportManager.exportReportToPdfFile(jp, chemin + title + ".pdf");
                HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                response.addHeader("Context-disposition", "attacement;filename=" + title + ".pdf");
                ServletOutputStream stream = response.getOutputStream();
                JasperExportManager.exportReportToPdfStream(jp, stream);
                FacesContext.getCurrentInstance().responseComplete();
            } catch (JRException ex) {
                ex.printStackTrace();
                displayErrorMessage("Probleme pour generer le fichier d'impression");
                //Logger.getMessageLogger(this.getClass(), report, Locale.ITALY);
            }
        }

    }
}



///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.controller;
//
//import com.models.MagasinFacade;
//import com.utils.JSFUtils;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import java.util.Map;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletResponse;
//import javax.faces.context.FacesContext;
//import java.io.File;
//import java.io.IOException;
//import java.sql.Connection;
//import java.util.List;
//import javax.inject.Inject;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.design.JRDesignQuery;
//import net.sf.jasperreports.engine.design.JasperDesign;
//import net.sf.jasperreports.engine.xml.JRXmlLoader;
//   
///**
// *
// * @author ZORE
// */
//public class AbstractBean {
//
//    @Inject
//    private MagasinFacade mf;
//
//    public AbstractBean() {
//    }
//
//    protected void displayInfoMessage(String message) {
//        JSFUtils fUtils = new JSFUtils();
//        fUtils.sendInfoMessage(message);
//    }
//
//    protected void displayErrorMessage(String message) {
//        JSFUtils fUtils = new JSFUtils();
//        fUtils.sendErrorMessage(message);
//    }
//
//    public void PDF2(Map<String, Object> params, String jasperPath, String sql, String chemin, String filename, Connection conn) throws JRException, IOException {
//
//        try {
////            String relativeWebPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(jasperPath);
////            File file = new File(relativeWebPath);
////            // - Chargement et compilation du rapport
////            JasperDesign jasperDesign = JRXmlLoader.load(file.getPath());
////            //JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
////            JRDesignQuery newQuery = new JRDesignQuery();
////            newQuery.setText(sql);
////            jasperDesign.setQuery(newQuery);
////            JasperReport jr = JasperCompileManager.compileReport(jasperDesign);
////
////            //JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(datasource, false);
////            //JasperPrint print = JasperFillManager.fillReport(file.getPath(), params, new JREmptyDataSource());
////            // - Execution du rapport
////            JasperPrint print = JasperFillManager.fillReport(jr, params, conn);
////            JasperExportManager.exportReportToPdfFile(print, chemin + filename);
////            JasperViewer.viewReport(print);
////
//////        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//////        response.addHeader("Context-disposition", "attacement;filename=" + filename);
//////        ServletOutputStream stream = response.getOutputStream();
//////        JasperExportManager.exportReportToPdfStream(print, stream);
//////        FacesContext.getCurrentInstance().responseComplete();
//            String relativeWebPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(jasperPath);
//            File file = new File(relativeWebPath);
//            //JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(datasource, false);
//            JasperDesign jasperDesign = JRXmlLoader.load(file.getPath());
//            //JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//            JasperPrint print = JasperFillManager.fillReport(file.getPath(), params, conn);
//            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//            response.addHeader("Context-disposition", "attacement;filename=" + filename);
//            ServletOutputStream stream = response.getOutputStream();
//            JasperExportManager.exportReportToPdfStream(print, stream);
//            FacesContext.getCurrentInstance().responseComplete();
//        } catch (JRException e) {
//            displayErrorMessage("erreur lors de l'impression du fichier");
//        }
//    }
//
//    public void PDF(Map<String, Object> params, String jasperPath, List<?> datasource, String filename) throws JRException, IOException {
//            System.out.print("****real path****:"+FacesContext.getCurrentInstance().getExternalContext().getRealPath(jasperPath));
//        if (datasource != null) {
//            String relativeWebPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(jasperPath);
//            File file = new File(relativeWebPath);
//            JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(datasource, false);
//            System.out.println("" + file.getPath());
//            JasperPrint print = JasperFillManager.fillReport(file.getPath(), params, beanCollectionDataSource);
//            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//            response.addHeader("Context-disposition", "attacement;filename=" + filename);
//            ServletOutputStream stream = response.getOutputStream();
//            JasperExportManager.exportReportToPdfStream(print, stream);
//            FacesContext.getCurrentInstance().responseComplete();
//        } else {
//            displayErrorMessage("la liste est vide");
//        }
//
//    }
//
//    public void report(Map<String, Object> params, String report, String sql, String chemin, String title, Connection conn) throws IOException, JRException {
//        if(mf.executeNativeQuery(sql).size()>0){
//        if (conn != null) {
//            try {
//
//                //BasicConfigurator.configure();
//                String lieuFichier = report;//"/report/"+report;
//                String rech = FacesContext.getCurrentInstance().getExternalContext().getRealPath(lieuFichier);
//                // System.out.print("****real path****:"+rech);
//                File file = new File(rech);
//                JasperDesign jd = JRXmlLoader.load(file.getPath());
//                JRDesignQuery newQuery = new JRDesignQuery();
//                newQuery.setText(sql);
//                jd.setQuery(newQuery);
//                JasperReport jr = JasperCompileManager.compileReport(jd);
//                JasperPrint jp = JasperFillManager.fillReport(jr, params, conn);
//                //JasperExportManager.exportReportToPdfFile(jp, chemin + title + ".pdf");
//                HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//                response.addHeader("Context-disposition", "attacement;filename=" + title + ".pdf");
//                ServletOutputStream stream = response.getOutputStream();
//                JasperExportManager.exportReportToPdfStream(jp, stream);
//                FacesContext.getCurrentInstance().responseComplete();
//            } catch (JRException ex) {
//                ex.printStackTrace();
//                displayErrorMessage("Probleme pour generer le fichier d'impression");
//                //Logger.getMessageLogger(this.getClass(), report, Locale.ITALY);
//            }
//        }
//        }else{
//            displayErrorMessage("la liste est vide");
//        }
//
//    }
//    
//}
