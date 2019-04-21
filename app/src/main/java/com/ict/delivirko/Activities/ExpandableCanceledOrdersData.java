package com.ict.delivirko.Activities;

import com.ict.delivirko.Module.pilot.CanceledOrder;
import com.ict.delivirko.Module.pilot.CanceledOrdersDetails;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableCanceledOrdersData {
    public static HashMap<CanceledOrder, List<CanceledOrdersDetails>> getData() {
        HashMap<CanceledOrder, List<CanceledOrdersDetails>> hashMap = new HashMap();
        List arrayList = new ArrayList();
        arrayList.add(new CanceledOrdersDetails());
        arrayList.add(new CanceledOrdersDetails());
        arrayList.add(new CanceledOrdersDetails());
        arrayList.add(new CanceledOrdersDetails());
        List arrayList2 = new ArrayList();
        arrayList2.add(new CanceledOrdersDetails());
        arrayList2.add(new CanceledOrdersDetails());
        arrayList2.add(new CanceledOrdersDetails());
        arrayList2.add(new CanceledOrdersDetails());
        List arrayList3 = new ArrayList();
        arrayList3.add(new CanceledOrdersDetails());
        arrayList3.add(new CanceledOrdersDetails());
        hashMap.put(new CanceledOrder(), arrayList);
        hashMap.put(new CanceledOrder(), arrayList2);
        hashMap.put(new CanceledOrder(), arrayList3);
        return hashMap;
    }
}
