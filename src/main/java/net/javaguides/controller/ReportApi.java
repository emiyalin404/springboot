package net.javaguides.controller;

import net.javaguides.Dynamic.ExportType;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@RequestMapping(path = "reports")
@RequestMapping("/VueTestApi/api/VueTest")
public interface ReportApi {
    @GetMapping(value = "transactions/download")
    ResponseEntity<Void> downloadTransactionReport(@RequestParam(value = "exportType") ExportType exportType,
                                                   HttpServletResponse response) throws IOException, JRException;

    // new endpoint to generate & EXPORT dynamic report
    @GetMapping(value = "dynamic/transactions/download")
    ResponseEntity<Void> exportDynamicTransactionReport(@RequestParam(value = "exportType") ExportType exportType,
                                                        HttpServletResponse response) throws IOException, JRException;
}
