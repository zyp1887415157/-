package com.lanou.service;

import java.util.List;

public interface PersonService {

    int deleteOne (Integer id);

    int delete(List<Integer> ids);
}
