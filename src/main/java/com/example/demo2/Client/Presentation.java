package com.example.demo2.Client;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
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
        this.login();
        this.getUser();
//        Button button = new Button("login");
//        TextField name = new TextField();
//        TextField password = new TextField();
//        add(name,password, button);
//        button.addClickListener(buttonClickEvent -> pc.login(name.getValue(), password.getValue()));
    }

    public void register(){
        Button button = new Button("register");
        Text nameTitle = new Text("name");
        TextField name = new TextField();
        HorizontalLayout nameAndTitle = new HorizontalLayout(nameTitle, name);
        Text passwordTitle = new Text("name");
        TextField password = new TextField();
        TextField validatePassword = new TextField();
        add(nameAndTitle,password,validatePassword, button);
        button.addClickListener(buttonClickEvent -> pc.register(name.getValue(), password.getValue(), validatePassword.getValue()));
    }

    public void login(){
        Button button = new Button("login");
        TextField name = new TextField();
        TextField password = new TextField();
        add(name,password, button);
        button.addClickListener(buttonClickEvent -> pc.login());
    }

    public void getUser(){
        TextField name = new TextField();
        Button button = new Button("search user");
        add(name, button);
        button.addClickListener(buttonClickEvent -> pc.getUser(name.getValue()));
    }




}
