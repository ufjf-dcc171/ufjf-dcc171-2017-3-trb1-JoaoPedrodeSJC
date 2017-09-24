package br.ufjf.dcc171;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class TiposListModel implements ListModel<Tipo> {

    private final List<Tipo> Tipos;
    private final List<ListDataListener> dataListeners;

    public TiposListModel(List<Tipo> Tipos) {
        this.Tipos = Tipos;
        this.dataListeners =  new ArrayList<>();
    }

    @Override
    public int getSize() {
        return Tipos.size();
    }

    @Override
    public Tipo getElementAt(int index) {
        return Tipos.get(index);
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
