package org.a.a.b;

import java.util.Iterator;
import org.a.a.c.d;

public strictfp interface c extends Iterable {
    d a();

    @Override
    default Iterator iterator() {
        return null;
    }
}
