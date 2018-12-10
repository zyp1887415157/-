package com.lanou.mapper;

import java.util.List;

public interface PersonMapper {

    int deleteOne (Integer id);

    int delete(List<Integer> ids);

}
