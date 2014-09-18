package com.example.adapter;

import java.util.List;

import com.example.bean.CategoriaBean;
import com.example.volleyexample.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CategoriaAdapter extends BaseAdapter {

	private Activity activity;
	private LayoutInflater inflater;
	private List<CategoriaBean> categorias;

	public CategoriaAdapter(Activity activity, List<CategoriaBean> categorias) {
		this.activity = activity;
		this.categorias = categorias;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return categorias.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return categorias.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		if (inflater == null) {
			inflater = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.list_row, null);
		}

		TextView descripcion = (TextView) convertView
				.findViewById(R.id.descripcion);
		TextView plataforma = (TextView) convertView
				.findViewById(R.id.plataforma);

		CategoriaBean objCategoria = categorias.get(position);
		descripcion.setText(objCategoria.getCat_descripcion());
		plataforma.setText(objCategoria.getPlat_id());

		return convertView;
	}

}
