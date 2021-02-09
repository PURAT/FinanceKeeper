package com.example.saveload;

import com.example.constants.Text;
import com.example.model.Currency;
import com.example.settings.Settings;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RateCurrency {

    static HashMap<String, Double> loadRates(Currency base) {
        HashMap<String, NodeList> map = new HashMap<>();
        HashMap<String, Double> rates = new HashMap<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String URL = "http://www.cbr.ru/scripts/XML_daily.asp?date_req=" + dateFormat.format(new Date());

        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(URL);

            Node root = document.getDocumentElement();
            NodeList currencies = root.getChildNodes();
            for (int i = 0; i < currencies.getLength(); i++) {
                Node currency = currencies.item(i);
                NodeList props = currency.getChildNodes();
                for (int j = 0; j < props.getLength(); j++) {
                    Node currencyProp = props.item(j);
                    if (currencyProp.getNodeName().equals("CharCode"))
                        map.put(currencyProp.getTextContent(), props);
                }
            }

            for (Map.Entry<String, NodeList> entry: map.entrySet()) {
                String code = entry.getKey();
                NodeList temp = entry.getValue();
                double value = 0;
                int nominal = 0;
                for (int i = 0; i < temp.getLength(); i++) {
                    Node node = temp.item(i);
                    if (node.getNodeName().equals("Value"))
                        value = Double.parseDouble(node.getTextContent().replace(",","."));
                    else if (node.getNodeName().equals("Nominal"))
                        nominal = Integer.parseInt(node.getTextContent());
                }
                double amount = value / nominal;
                rates.put(code, amount);
            }
            // RUB doesn't exist in XML file
            rates.put("RUB", 1.0);

            double baseRate = rates.get(base.getCode());
            for (Map.Entry<String, Double> entry: rates.entrySet()) {
                // for 4 decimal places
                entry.setValue((double) Math.round(entry.getValue() / baseRate * 10000) / 10000);
            }

        } catch (ParserConfigurationException | SAXException e) {
            System.out.println("Произошла ошибка при попытке спарсить XML файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rates;
    }
}
