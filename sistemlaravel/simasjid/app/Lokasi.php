<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Lokasi extends Model
{
    //
    protected $table = 'lokasi';

    public $timestamps = false; 

    protected $fillable = [
        'id', 'nama'
    ];
}