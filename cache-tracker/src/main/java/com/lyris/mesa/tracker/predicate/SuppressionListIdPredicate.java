package com.lyris.mesa.tracker.predicate;

import java.util.Map.Entry;
import java.util.Set;

import com.hazelcast.query.Predicate;
import com.lyris.mesa.model.segment.SegmentResponseVO;

/**
 * This SuppressionListIdPredicate to apply filter on suppressionListIds
 * 
 * @author ThirupathiReddy V
 * @version 1.0
 * @since 1.4.0 (canvas)
 *
 */
public class SuppressionListIdPredicate implements Predicate<String, SegmentResponseVO> {

    /**
     * 
     */
    private static final long serialVersionUID = 7734697872256769829L;

    Set<Integer> suppressionListIds;

    public SuppressionListIdPredicate(Set<Integer> suppressionListIds) {

        this.suppressionListIds = suppressionListIds;
    }

    @Override
    public boolean apply(Entry<String, SegmentResponseVO> mapEntry) {
        
        // since it is optional value we can't return false if this set is empty or null
        if (suppressionListIds == null && suppressionListIds.isEmpty()) {
            return true;
        }

        SegmentResponseVO serviceVO = mapEntry.getValue();

        for (Integer suppressionListId : serviceVO.getAudience().getLhqSuppressionListIds()) {
            if (suppressionListIds.contains(suppressionListId)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        return " audience.lhqSuppressionListIds contains any  "+suppressionListIds;
    }
}
