package br.ufjf.dcc171;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class ComidasListModel implements ListModel<Comida> {

    private final List<Comida> comidas;
    private final List<ListDataListener> dataListeners;

    public ComidasListModel(List<Comida> comidas) {
        this.comidas = comidas;
        this.dataListeners =  new ArrayList<>();
    }

    @Override
    public int getSize() {
        return comidas.size();
    }

    @Override
    public Comida getElementAt(int index) {
        return comidas.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        this.dataListeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        this.dataListeners.remove(l);
    }
    
}
