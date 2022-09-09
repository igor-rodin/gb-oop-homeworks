package hw2.gen;

import hw2.gen.geotree.Genealogical;

public interface Storage {
    void save(Genealogical gTree);

    Genealogical load();
}
