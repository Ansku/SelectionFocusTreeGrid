package com.vaadin.selectionfocustreegrid.client;

import com.vaadin.client.widget.escalator.EscalatorUpdater;
import com.vaadin.client.widget.escalator.Row;
import com.vaadin.client.widget.treegrid.TreeGrid;
import com.vaadin.client.widgets.Grid;
import com.vaadin.shared.Range;

public class SelectionFocusTreeGridWidget extends TreeGrid {

    public SelectionFocusTreeGridWidget() {
        super();
        addStyleName("selectionfocustreegrid");
    }

    @Override
    protected EscalatorUpdater createBodyUpdater() {
        return new SelectionFocusBodyUpdater();
    }

    protected class SelectionFocusBodyUpdater extends BodyUpdater {
        @SuppressWarnings("rawtypes")
        @Override
        public void update(Row row, Iterable cellsToUpdate) {
            String rowSelectedStyleName = getStylePrimaryName()
                    + "-row-selected";
            boolean selectedPreviously = row.getElement()
                    .hasClassName(rowSelectedStyleName);
            super.update(row, cellsToUpdate);
            String rowFocusedStyleName = getStylePrimaryName() + "-row-focused";
            if (!selectedPreviously
                    && row.getElement().hasClassName(rowSelectedStyleName)
                    && !row.getElement().hasClassName(rowFocusedStyleName)) {
                focusCell(row.getRow(),
                        getFocusedColumnRange(cellFocusHandler).getStart());
            }
        }
    }

    /**
     * Method for accessing the private
     * {@link Grid.CellFocusHandler#cellFocusRange} variable.
     */
    private native Range getFocusedColumnRange(Object cellFocusHandler)
    /*-{
        return cellFocusHandler.@com.vaadin.client.widgets.Grid.CellFocusHandler::cellFocusRange;
    }-*/;

}