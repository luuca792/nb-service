package ctu.se.oda.model11.errors.messages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class CustomMessageException {
    public final static String NOTEBOOK_NOT_FOUND_BY_ID = "CAN NOT FIND ANY NOTEBOOKS WITH THIS ID";
}