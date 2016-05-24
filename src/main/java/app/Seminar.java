package app;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by cduffau on 24/05/16.
 */
public class Seminar {

    private SimpleStringProperty name;
    private SimpleStringProperty time;
    private SimpleStringProperty mark;

    public Seminar(String name, String time, String mark){
        this.name=new SimpleStringProperty(name);
        this.time=new SimpleStringProperty(time);
        this.mark=new SimpleStringProperty(mark);
    }

    public String getName(){
        return this.name.get();
    }
    public void setName(String name){
        this.name=new SimpleStringProperty(name);
    }

    public String getTime(){
        return this.time.get();
    }
    public void setTime(String time){
        this.time=new SimpleStringProperty(time);
    }
    public String getMark(){
        return this.mark.get();
    }
    public void setMark(String mark){
        this.mark=new SimpleStringProperty(mark);
    }

    @Override
    public String toString() {
        return "app.Seminar{" + "\n"+
                "name=" + name.get() + "\n"+
                ", time=" + time.get() + "\n"+
                ", mark=" + mark.get() + "\n"+
                '}' +"\n";
    }
}
