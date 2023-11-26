package ctu.se.oda.model11.errors.messages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CustomMessageException {
    public final static String NOTEBOOK_NOT_FOUND_BY_ID = "CAN NOT FIND ANY NOTEBOOKS WITH THIS ID";
    public final static String FIELD_TYPE_NOT_FOUND_BY_ID = "CAN NOT FIND ANY FIELD TYPE WITH THIS ID";
    public final static String FIELD_NOT_FOUND_BY_ID = "CAN NOT FIND ANY FIELD WITH THIS ID";
    public final static String VALUE_NOT_FOUND_BY_ID = "CAN NOT FIND ANY VALUE WITH THIS ID";


}
