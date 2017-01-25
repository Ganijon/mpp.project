package library.domain;

import java.util.List;

public class CheckoutRecord {

    private Member member;
    private List<CheckoutEntry> checkoutList;
    private List<FineEntry> fineList;
}
