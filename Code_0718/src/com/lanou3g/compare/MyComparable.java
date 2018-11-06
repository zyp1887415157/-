package com.lanou3g.compare;

import com.lanou3g.Person;

public interface MyComparable<T> {
    int compareTo(T other);
}
