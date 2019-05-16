package com.luer.comm.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * A POJO representing a jQgrid's jsonReader property.
 * @author max
 * @see <a href="http://www.trirand.com/jqgridwiki/doku.php?id=wiki:retrieving_data#json_data">JSON Data</a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JqgridResponse<T extends Serializable>  {

    /**
     * Current page
     */
    private Integer page;

    /**
     * Total pages
     */
    private Integer  total;

    /**
     * Total number of records
     */
    private Long records;

    /**
     * Contains the actual data
     */
    private List<T> rows;

}
