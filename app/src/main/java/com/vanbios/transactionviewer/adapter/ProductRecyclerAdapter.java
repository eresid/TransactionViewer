package com.vanbios.transactionviewer.adapter;

import android.content.Context;
import android.os.Bundle;

import com.vanbios.transactionviewer.MainActivity;
import com.vanbios.transactionviewer.R;
import com.vanbios.transactionviewer.enums.FrgEnum;
import com.vanbios.transactionviewer.fragment.FrgTransactions;
import com.vanbios.transactionviewer.object.Product;

import java.util.List;

/**
 * @author Ihor Bilous
 */
public class ProductRecyclerAdapter extends GenericRecyclerAdapter {

    @SuppressWarnings("unchecked")
    public ProductRecyclerAdapter(Context context, List<Product> list) {
        super(context, list);
    }

    @Override
    public void onBindViewHolder(GenericViewHolder holder, int position) {
        Product product = (Product) list.get(position);
        holder.tvTitle.setText(product.getName());
        holder.tvSubTitle.setText(String.format
                (context.getString(R.string.transactions_count_placeholder),
                        product.getTransactionsList().size()));
        holder.view.setOnClickListener(view -> openTransactions(product));
    }

    private void openTransactions(Product product) {
        MainActivity activity = (MainActivity) context;
        FrgTransactions frg = new FrgTransactions();
        Bundle args = new Bundle();
        args.putString(FrgTransactions.PRODUCT, product.getName());
        frg.setArguments(args);
        activity.addFragment(frg, FrgEnum.TRANSACTIONS.name());
    }
}