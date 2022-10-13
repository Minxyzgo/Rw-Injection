package org.a.a.b;

import java.util.Iterator;

public strictfp interface b extends Iterable {
    org.a.a.c.b a();

    @Override
    default Iterator iterator() {
        return null;
    }
}
