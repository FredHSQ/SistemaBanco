package applications;

import java.util.Comparator;
import java.util.Map;

import contas.Conta;

class ValueComparator implements Comparator<String> {
    Map<String, Conta> base;

    public ValueComparator(Map<String, Conta> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with
    // equals.
    public int compare(String a, String b) {
        return base.get(a).getNome().compareToIgnoreCase(base.get(b).getNome());
    }
}
