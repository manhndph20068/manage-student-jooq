package com.example.managestudentjooq.dto.request;

import com.example.managestudentjooq.dto.paging.Filter;
import com.example.managestudentjooq.dto.paging.Order;
import com.example.managestudentjooq.dto.paging.Pageable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true) // SearchRequest request = new SearchRequest().setPage(1).setPageSize(20).setKeyword("key");
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SearchRequest {
    private int page;
    private int pageSize = 10;
    private String keyword;
    private List<Order> sorts;
    private List<Filter> filters;

    @JsonIgnore
    public Integer getOffset() {
        return Math.max((page - 1) * pageSize, 0);
    }

    public int getPageSize() {
        if (this.pageSize < 0) return Pageable.MAXIMUM_PAGE_SIZE;
        return pageSize;
    }


//    {
//        "page": 1,
//            "pageSize": 10,
//            "keyword": "example",
//            "sorts": [
//        {
//            "property": "name",
//                "direction": "asc"
//        }
//  ],
//        "filters": [
//        {
//            "name": "status",
//                "value": "active",
//                "operation": "="
//        }
//  ]
//    }

}
