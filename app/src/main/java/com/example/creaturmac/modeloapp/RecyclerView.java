package com.example.creaturmac.modeloapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class RecyclerView extends AppCompatActivity {

    private RecyclerView recView;

    private ArrayList<Titular> datos;

    private ListView lstOpciones1;
    private TextView lblEtiqueta;

    // ArrayList de tipo Titular
   /* private Titular[] datos =
            new Titular[]{
                    new Titular("Título 1", "Subtítulo largo 1"),
                    new Titular("Título 2", "Subtítulo largo 2"),
                    new Titular("Título 3", "Subtítulo largo 3"),
                    new Titular("Título 4", "Subtítulo largo 4"),
                    new Titular("Título 5", "Subtítulo largo 5"),
                    new Titular("Título 6", "Subtítulo largo 6"),
                    new Titular("Título 7", "Subtítulo largo 7"),
                    new Titular("Título 8", "Subtítulo largo 8"),
                    new Titular("Título 9", "Subtítulo largo 9"),
                    new Titular("Título 10", "Subtítulo largo 10"),
                    new Titular("Título 11", "Subtítulo largo 11"),
                    new Titular("Título 12", "Subtítulo largo 12"),
                    new Titular("Título 13", "Subtítulo largo 13"),
                    new Titular("Título 14", "Subtítulo largo 14"),
                    new Titular("Título 15", "Subtítulo largo 15")
            };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        //inicialización de la lista de datos de ejemplo
        datos = new ArrayList<Titular>();
        for(int i=0; i<50; i++)
            datos.add(new Titular("Título " + i, "Subtítulo item " + i));

        //Inicialización RecyclerView
        recView = (RecyclerView)findViewById(R.id.RecView);
        recView.setHasFixedSize(true);

        final AdaptadorTitulares adaptador = new AdaptadorTitulares(this, datos);

        recView.setAdapter(adaptador);

        recView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        //-- .. -- .. -- .. -- .. --
        lblEtiqueta = (TextView)findViewById(R.id.lblEtiqueta);
        lstOpciones1 = (ListView)findViewById(R.id.LstOpciones1);

        //-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
        AdaptadorTitulares adaptador1 =
                new AdaptadorTitulares(this, datos);

        lstOpciones1 = (ListView)findViewById(R.id.LstOpciones1);
        lstOpciones1.setAdapter(adaptador1);

        //-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
        View header = getLayoutInflater().inflate(R.layout.list_header, null);
        lstOpciones1.addHeaderView(header);
        //-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
        lstOpciones1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                //Alternativa 1:
                String opcionSeleccionada =
                        ((Titular)a.getItemAtPosition(position)).getTitulo();

                //Alternativa 2:
                //String opcionSeleccionada =
                //      ((TextView)v.findViewById(R.id.LblTitulo))
                //          .getText().toString();

                lblEtiqueta.setText("Opción seleccionada: " + opcionSeleccionada);
            }
        });

    }
    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
    public class Titular
    {
        private String titulo;
        private String subtitulo;

        public Titular(String tit, String sub){
            titulo = tit;
            subtitulo = sub;
        }

        public String getTitulo(){
            return titulo;
        }

        public String getSubtitulo(){
            return subtitulo;
        }
    }
    //--

    class AdaptadorTitulares extends ArrayAdapter<Titular> {

        public AdaptadorTitulares(Context context, Titular[] datos1) {
            super(context, R.layout.listitem_titular, datos);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_titular, null);

            TextView lblTitulo = (TextView)item.findViewById(R.id.LblTitulo);
            lblTitulo.setText(datos[position].getTitulo());

            TextView lblSubtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
            lblSubtitulo.setText(datos[position].getSubtitulo());

            return(item);
        }
    }

    public class AdaptadorTitulares
            extends RecyclerView.Adapter<AdaptadorTitulares.TitularesViewHolder> {

        private ArrayList<Titular> datos1;

        public static class TitularesViewHolder extends RecyclerView.ViewHolder {

            private TextView txtTitulo;
            private TextView txtSubtitulo;

            public TitularesViewHolder(View itemView) {
                super(itemView);

                txtTitulo = (TextView)itemView.findViewById(R.id.LblTitulo);
                txtSubtitulo = (TextView)itemView.findViewById(R.id.LblSubTitulo);
            }

            public void bindTitular(Titular t) {
                txtTitulo.setText(t.getTitulo());
                txtSubtitulo.setText(t.getSubtitulo());
            }
        }
        public AdaptadorTitulares(RecyclerView recyclerView, ArrayList<Titular> datos) {
            this.datos = datos;
        }

        @Override
        public TitularesViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

            View itemView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.listitem_titular, viewGroup, false);

            TitularesViewHolder tvh = new TitularesViewHolder(itemView);

            return tvh;
        }

        @Override
        public void onBindViewHolder(TitularesViewHolder viewHolder, int pos) {
            Titular item = datos.get(pos);

            viewHolder.bindTitular(item);
        }

        @Override
        public int getItemCount() {
            return datos.size();
        }
    }


}
