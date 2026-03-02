package com.froyo.initial;

import com.froyo.messages.AbstractResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MapObjectRowResponse extends AbstractResponse {

    private final List<Map<String, Object>> rows = new ArrayList<>();

    public List<Map<String, Object>> getRows() {
        return rows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        MapObjectRowResponse that = (MapObjectRowResponse) o;
        return Objects.equals(rows, that.rows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rows);
    }

    @Override
    public String toString() {
        return "MapObjectRowResponse{" +
                "rows=" + rows +
                "} " + super.toString();
    }
}
