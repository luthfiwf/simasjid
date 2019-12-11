<?php

namespace App\Http\Controllers;

use App\Pengelola_Aset;
use App\PJ_Kategori;
use App\Kategori;
use Auth;
use Illuminate\Http\Request;

class KategoriController extends Controller
{

    public function index()
    {
        //list pengelola
        $obj_list_pengelola = Pengelola_Aset::get();
        $arr_list_pengelola = [];
        foreach ($obj_list_pengelola as $pengelola) {
            $arr_list_pengelola[] = $pengelola->id_anggota;
        }
        $list_kategori = Kategori::get();
        foreach ($list_kategori as $kategori) {
            $kategori->list_pj_kategori;
            foreach ($kategori->list_pj_kategori as $pj_kategori) {
                $pj_kategori->anggota_pj_kategori;
            }
        }
        // $group_pj_kategori = PJ_Kategori::get()->groupBy('id_kategori');

        // for ($x = 1; $x < sizeof($group_pj_kategori); $x++) {
        //     for ($y = 0; $y < sizeOf($group_pj_kategori[$x]); $y++) {
        //         echo $group_pj_kategori[$x][$y]->id_kategori;
        //     }
        // }


        // return $group_pj_kategori;
        //user terotentikasi
        $anggota = Auth::user();

        // return $list_kategori;

        return view('aset.kategori', ['list_kategori' => $list_kategori, 'list_pengelola' => $arr_list_pengelola, 'anggota' => $anggota]);

        //retval
        // return view('aset.usulan', ['list_usulan' => $list_usulan, 'list_pengelola' => $arr_list_pengelola, 'anggota' => $anggota]);
    }

    public function get(Request $request)
    {
        $kategori = Kategori::get()->where('id', '=', $request->id);
        return $kategori;
    }
}