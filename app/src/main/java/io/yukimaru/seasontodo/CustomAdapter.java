package io.yukimaru.seasontodo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Item> {
    List<Item> items;

    public CustomAdapter(Context context, int resource, List<Item> items) {
        super(context, resource, items);

        this.items = items;
    }

    @Override
    public int getCount() {//adapter内のアイテムの数をitemsから数える。size->要素の個数。
        return items.size();
    }

    public Item getItem(int position) {// adapterが正しくものを並べられるように、どこに何の情報が入ってるかを見つける。adapterが勝手に使う。
        return items.get(position);
    }

    public static class ViewHolder {
        TextView checkboxText;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {//itemに対応するviewを作ってviewHolderに返す
        final ViewHolder viewHolder;

        if (convertView != null) {//convertView->こすれば情報が消えるスタンプ的な。convertViewがnullではない時はスタンプに情報を掘る。
            viewHolder = (ViewHolder) convertView.getTag();
        } else {//convertViewがnullの時はスタンプを一から作る。
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cell, parent, false);
            viewHolder = new ViewHolder();

            viewHolder.checkboxText = (TextView) convertView.findViewById(R.id.checkbox_text);
            convertView.setTag(viewHolder);
        }

        Item item = items.get(position);

        viewHolder.checkboxText.setText(item.getContent());

        return convertView;
    }

    public Item getItemByKey(String key) {
        for (Item item : items) {
            if (item.getKey().equals(key)) {
                return item;
            }
        }

        return null;
    }
}
