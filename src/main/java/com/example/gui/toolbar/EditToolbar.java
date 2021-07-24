package com.example.gui.toolbar;

import com.example.constants.CodeAction;
import com.example.constants.Style;
import com.example.constants.Text;
import com.example.gui.EnableEditDelete;
import com.example.gui.MainButton;
import com.example.handler.Handler;


public class EditToolbar extends AbstractToolbar implements EnableEditDelete {

    private MainButton editButton;
    private MainButton deleteButton;


    public EditToolbar(Handler handler) {
        super(Style.BORDER_TOOLBAR, handler);
    }

    @Override
    void init() {
        addButton(Text.TOOLBAR_ADD, Style.ICON_TOOLBAR_ADD, CodeAction.BUTTON_ADD, false);
        editButton = addButton(Text.TOOLBAR_EDIT, Style.ICON_TOOLBAR_EDIT, CodeAction.BUTTON_EDIT, false);
        deleteButton = addButton(Text.TOOLBAR_DELETE, Style.ICON_TOOLBAR_DELETE, CodeAction.BUTTON_DELETE, false);
    }

    @Override
    public void setEnableEditDelete(boolean enable) {
        editButton.setEnabled(enable);
        deleteButton.setEnabled(enable);
    }
}
