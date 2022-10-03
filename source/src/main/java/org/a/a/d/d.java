package org.a.a.d;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public strictfp interface d extends org.a.a.a.d, c {
    org.a.a.c.d a();

    org.a.a.e.d b();

    org.a.a.e.d a(int p0);

    d a(int p0, int p1);

    @Deprecated
    Short b(int p0);

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
