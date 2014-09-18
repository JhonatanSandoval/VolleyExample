package com.example.volleyexample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.adapter.CategoriaAdapter;
import com.example.app.AppController;
import com.example.app.VolleySingleton;
import com.example.bean.CategoriaBean;
import com.example.util.Constantes;

import android.support.v7.app.ActionBarActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

	private List<CategoriaBean> categorias = new ArrayList<CategoriaBean>();
	private ListView listaCategorias;
	private CategoriaAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final ProgressDialog pDialog = new ProgressDialog(this);
		pDialog.setMessage("Cargando categorías...");
		pDialog.show();

		listaCategorias = (ListView) findViewById(R.id.listaCategorias);
		adapter = new CategoriaAdapter(this, categorias);
		listaCategorias.setAdapter(adapter);

		Log.d("App", "termino de setear variables");

		StringRequest jsonReq = new StringRequest(Method.POST,
				Constantes.CATEG_x_PLATAFORMA, new Response.Listener<String>() {

					@Override
					public void onResponse(String response) {
						// TODO Auto-generated method stub
						Log.d("App", response.toString());
						pDialog.hide();

						Log.d("App", "oculto dialogo");

						try {
							JSONArray jsonArray = new JSONArray(response);
							Log.d("App",
									"Response length: " + jsonArray.length());

							for (int i = 0; i < jsonArray.length(); i++) {
								JSONObject jsonObj = jsonArray.getJSONObject(i);
								CategoriaBean objCategoria = new CategoriaBean();
								objCategoria.setCat_descripcion(jsonObj
										.getString("cat_descripcion"));
								String plat_id = jsonObj.getString("plat_id");
								String plataforma = "";
								if (plat_id.equals("1")) {
									plataforma = "iOS";
								} else {
									plataforma = "Android";
								}
								objCategoria.setPlat_id(plataforma);
								categorias.add(objCategoria);
							}

						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						adapter.notifyDataSetChanged();
					}

				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						// TODO Auto-generated method stub
						VolleyLog.d("App", "Error: " + error.toString());
					}
				}) {

			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				Map<String, String> params = new HashMap<String, String>();

				params.put("idPlataforma", "1");
				return params;
			}

		};

		AppController.getInstance().addToRequestQueue(jsonReq);

	}
}
