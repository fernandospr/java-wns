package ar.com.fernandospr.wns.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * From <a href="https://msdn.microsoft.com/en-us/library/windows/apps/dn268318.aspx">https://msdn.microsoft.com/en-us/library/windows/apps/dn268318.aspx</a>
 */
@XmlRootElement(name = "commands")
public class WnsToastCommands {

    @XmlAttribute
    public String scenario;

    @JacksonXmlElementWrapper(useWrapping=false)
    @XmlElement(name = "command")
    public List<WnsToastCommand> command;

    public WnsToastCommands(String scenario) {
        this.scenario = scenario;
        this.command = new ArrayList<WnsToastCommand>();
    }

    public void addCommand(String id, String arguments) {
        this.command.add(new WnsToastCommand(id, arguments));
    }
}
