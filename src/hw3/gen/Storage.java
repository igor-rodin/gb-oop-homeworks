package hw3.gen;

import hw3.gen.geotree.Genealogical;

public interface Storage {
    void save(Genealogical gTree);

    Genealogical load();
}
