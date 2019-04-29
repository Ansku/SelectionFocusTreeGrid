package com.vaadin.selectionfocustreegrid.client;

import com.vaadin.client.ui.treegrid.TreeGridConnector;
import com.vaadin.selectionfocustreegrid.SelectionFocusTreeGrid;
import com.vaadin.shared.ui.Connect;

// change this to connect to TreeGrid directly if you want to affect all TreeGrids by default
@Connect(SelectionFocusTreeGrid.class)
public class SelectionFocusTreeGridConnector extends TreeGridConnector {

    @Override
    public SelectionFocusTreeGridWidget getWidget() {
        return (SelectionFocusTreeGridWidget) super.getWidget();
    }
}
