package GCafe.Activities;


import androidx.appcompat.app.AppCompatActivity;

public class OrderHistoryActivity extends AppCompatActivity {

}

    //    private RecyclerView recyclerView;
    //    private OrderHistoryAdapter adapter;
    //   private List<StructuredQuery.Order> orderList;

    //   private DatabaseReference databaseRef;
//
    //   @Override
    //  //   protected void onCreate(Bundle savedInstanceState) {
    //      super.onCreate(savedInstanceState);
    //       setContentView(R.layout.activity_order_history);

        // Initialize Firebase
    //     databaseRef = FirebaseDatabase.getInstance().getReference("orders");

        // Initialize RecyclerView and adapter
//        recyclerView = findViewById(R.id.order_history_recycler_view);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        orderList = new ArrayList<>();
        //       adapter = new OrderHistoryAdapter(this, orderList);
        //       recyclerView.setAdapter(adapter);

        // Get orders from Firebase
//        databaseRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                orderList.clear();
        //               for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
        //               Order order = snapshot.getValue(Order.class);
        //                 orderList.add(order);
        //             }
        //         adapter.notifyDataSetChanged();
      //      }

    //       @Override
    //        public void onCancelled(@NonNull DatabaseError databaseError) {
                //            Log.e("OrderHistoryActivity", "Failed to read value.", databaseError.toException());
//  }
//   });
//   }
//}
