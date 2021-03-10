package br.com.livrospockframework.capitulo07.services;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;

import java.util.List;

public class EnvioEmailService {

    private Email email;
    private int enviados;

    public EnvioEmailService(Email email){
        this.email = email;
    }

    public void enviarEmails(String assunto, String conteudo, List<String> destinatarios) throws EmailException {
        this.email.setSubject(assunto);
        this.email.setMsg(conteudo);
        this.email.addTo(destinatarios.toArray(new String[destinatarios.size()]));
        this.email.send();
        this.enviados++;
    }

    public int getEnviados() {
        return enviados;
    }

    public void setEnviados(int enviados) {
        this.enviados = enviados;
    }
}
