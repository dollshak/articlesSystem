package com.example.demo2.Client;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class Presentation extends VerticalLayout {
    private PresentationController pc;
    public Presentation(){
        this.pc = new PresentationController();
//        register();
        this.register();
//        Button button = new Button("login");
//        TextField name = new TextField();
//        TextField password = new TextField();
//        add(name,password, button);
//        button.addClickListener(buttonClickEvent -> pc.login(name.getValue(), password.getValue()));
    }

    public void register(){
        Button button = new Button("register");
        TextField name = new TextField();
        TextField password = new TextField();
        add(name,password, button);
        button.addClickListener(buttonClickEvent -> pc.register());
    }

    public void login(){
        Button button = new Button("login");
        TextField name = new TextField();
        TextField password = new TextField();
        add(name,password, button);
        button.addClickListener(buttonClickEvent -> pc.login());
    }




}
