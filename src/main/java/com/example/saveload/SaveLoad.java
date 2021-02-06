package com.example.saveload;

import com.example.settings.Settings;

import javax.xml.bind.*;

public class SaveLoad {

    public static void save(SaveData data) {
        try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            Wrapper wrapper = new Wrapper();
            wrapper.setAccounts(data.getAccounts());
            wrapper.setArticles(data.getArticles());
            wrapper.setCurrencies(data.getCurrencies());
            wrapper.setTransactions(data.getTransactions());
            wrapper.setTransfers(data.getTransfers());

            marshaller.marshal(wrapper, Settings.getFileSave());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void load(SaveData data) {
        try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Wrapper wrapper = (Wrapper) unmarshaller.unmarshal(Settings.getFileSave());

            data.setAccounts(wrapper.getAccounts());
            data.setArticles(wrapper.getArticles());
            data.setCurrencies(wrapper.getCurrencies());
            data.setTransactions(wrapper.getTransactions());
            data.setTransfers(wrapper.getTransfers());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
