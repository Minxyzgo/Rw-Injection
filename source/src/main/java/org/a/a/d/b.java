package org.a.a.d;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public strictfp interface b extends org.a.a.a.b, c {
    org.a.a.c.b a();

    org.a.a.e.b b();

    org.a.a.e.b a(int p0);

    b a(int p0, int p1);

    @Deprecated
    Integer b(int p0);

    @Override
    default Iterator iterator() {
        return null;
    }

    @Override
    default List subList(int p0, int p1) {
        return null;
    }

    @Override
    default ListIterator listIterator(int p0) {
        return null;
    }

    @Override
    default ListIterator listIterator() {
        return null;
    }

    @Deprecated
    @Override
    default Object remove(int p0) {
        return null;
    }
}
