package com.example.creaturmac.modeloapp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListaOpt extends AppCompatActivity {

    private ListView lstOpciones1;
    private TextView lblEtiqueta;
    //private context;

    private Titular[] datos1 =
            new Titular[]{
                    new Titular("Hola 1", "Sub-Hola largo 1"),
                    new Titular("Hola 2", "Sub-Hola largo 2"),
                    new Titular("Hola 3", "Sub-Hola largo 3"),
                    new Titular("Hola 4", "Sub-Hola largo 4"),
                    new Titular("Hola 5", "Sub-Hola largo 5"),
                    new Titular("Hola 6", "Sub-Hola largo 6"),
                    new Titular("Hola 7", "Sub-Hola largo 7"),
                    new Titular("Hola 8", "Sub-Hola largo 8"),
                    new Titular("Hola 9", "Sub-Hola largo 9"),
                    new Titular("Hola 10", "Sub-Hola largo 10"),
                    new Titular("Hola 11", "Sub-Hola largo 11"),
                    new Titular("Hola 12", "Sub-Hola largo 12"),
                    new Titular("Hola 13", "Sub-Hola largo 13"),
                    new Titular("Hola 14", "Sub-Hola largo 14"),
                    new Titular("Hola 15", "Sub-Hola largo 15")
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_opt);

        lblEtiqueta = (TextView)findViewById(R.id.lblEtiqueta);
        lstOpciones1 = (ListView)findViewById(R.id.LstOpciones1);

        //-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
        AdaptadorTitulares adaptador1 =
                new AdaptadorTitulares(this, datos1);

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
    // -- -- -- -- --
    static class ViewHolder {
        TextView titulo;
        TextView subtitulo;
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
    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
    class AdaptadorTitulares extends ArrayAdapter<Titular> {

        public AdaptadorTitulares(Context context, Titular[] datos) {
            super(context, R.layout.listitem_titular, datos1);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_titular, null);

            TextView lblTitulo = (TextView)item.findViewById(R.id.LblTitulo);
            lblTitulo.setText(datos1[position].getTitulo());

            TextView lblSubtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
            lblSubtitulo.setText(datos1[position].getSubtitulo());

            return(item);
        }


    }

    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
    /*
    public View getView(int position, View convertView, ViewGroup parent, Activity context) {
        View item = convertView;

        if(item == null)
        {
            LayoutInflater inflater = context.getLayoutInflater();
            item = inflater.inflate(R.layout.listitem_titular, null);
        }

        TextView lblTitulo = (TextView)item.findViewById(R.id.LblTitulo);
        lblTitulo.setText(datos1[position].getTitulo());

        TextView lblSubtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
        lblSubtitulo.setText(datos1[position].getSubtitulo());

        return(item);
    }*/
    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
    public View getView(int position, View convertView, ViewGroup parent, Activity context)
    {
        View item = convertView;
        ViewHolder holder;

        if(item == null)
        {
            LayoutInflater inflater = context.getLayoutInflater();
            item = inflater.inflate(R.layout.listitem_titular, null);

            holder = new ViewHolder();
            holder.titulo = (TextView)item.findViewById(R.id.LblTitulo);
            holder.subtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);

            item.setTag(holder);
        }
        else
        {
            holder = (ViewHolder)item.getTag();
        }

        holder.titulo.setText(datos1[position].getTitulo());
        holder.subtitulo.setText(datos1[position].getSubtitulo());

        return(item);
    }
}
