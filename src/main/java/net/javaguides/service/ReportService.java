package net.javaguides.service;


import net.javaguides.enumeration.ExportType;
import net.sf.jasperreports.engine.JRException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transaction;
import java.io.IOException;
import java.util.List;

@Service
public class ReportService {

    public void downloadTransactionReport(ExportType exportType, HttpServletResponse response) throws JRException, IOException
    List<Transaction> transactionList = transactionService
}
