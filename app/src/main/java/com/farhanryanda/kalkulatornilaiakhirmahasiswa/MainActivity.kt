package com.farhanryanda.kalkulatornilaiakhirmahasiswa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var edtNama: EditText
    lateinit var edtNim: EditText
    lateinit var edtUas: EditText
    lateinit var edtUts: EditText
    lateinit var edtTugas: EditText
    lateinit var btnCalculate: Button
    lateinit var btnReset: Button
    lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNama = findViewById(R.id.edt_nama)
        edtNim = findViewById(R.id.edt_nim)
        edtUas = findViewById(R.id.edt_uas)
        edtUts = findViewById(R.id.edt_uts)
        edtTugas = findViewById(R.id.edt_tugas)
        btnCalculate = findViewById(R.id.btn_calculate)
        btnReset = findViewById(R.id.btn_reset)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener {
            edtNama.onEditorAction(EditorInfo.IME_ACTION_DONE)
            edtNim.onEditorAction(EditorInfo.IME_ACTION_DONE)
            edtUas.onEditorAction(EditorInfo.IME_ACTION_DONE)
            edtUts.onEditorAction(EditorInfo.IME_ACTION_DONE)
            edtTugas.onEditorAction(EditorInfo.IME_ACTION_DONE)
            var inputNama = edtNama.text.toString()
            var inputNim = edtNim.text.toString()
            var inputUas = edtUas.text.toString()
            var inputUts = edtUts.text.toString()
            var inputTugas = edtTugas.text.toString()

            var isEmptyFields = false

            if (inputNama.isEmpty()) {
                isEmptyFields = true
                edtNama.error = "Nama Tidak Boleh Kosong"
            }
            if (inputNim.isEmpty()) {
                isEmptyFields = true
                edtNim.error = "NIM Tidak Boleh Kosong"
            }
            if (inputUas.isEmpty()) {
                isEmptyFields = true
                edtUas.error = "UAS Tidak Boleh Kosong"
            }
            if (inputUts.isEmpty()) {
                isEmptyFields = true
                edtUts.error = "UTS Tidak Boleh Kosong"
            }
            if (inputTugas.isEmpty()) {
                isEmptyFields = true
                edtTugas.error = "Tugas Tidak Boleh Kosong"
            }
            if (!isEmptyFields) {
                var total = inputUas.toDouble() + inputUts.toDouble() + inputTugas.toDouble()
                var rataNilai = (inputUas.toDouble() + inputUts.toDouble() + inputTugas.toDouble()) / 3
                var nilaiHuruf: String
                var status: String
                if (rataNilai in 0.0..100.0) {
                    when(rataNilai) {
                        in 0.0..60.0 -> nilaiHuruf = "F"
                        in 61.0..70.0 -> nilaiHuruf = "D"
                        in 71.0..80.0 -> nilaiHuruf = "C"
                        in 81.0..90.0 -> nilaiHuruf = "B"
                        in 91.0..100.0 -> nilaiHuruf = "A"
                        else -> nilaiHuruf = "Nilai melebihi / kurang dari Batas"
                    }
                    when(nilaiHuruf) {
                        "A","B","C" -> status = "Lulus"
                        else -> status = "Tidak Lulus"
                    }
                } else {
                    nilaiHuruf = "Nilai Tidak Logis"
                    status = "Nilai Tidak Logis"
                }


                tvResult.text = """
                Nama Mahasiswa      = $inputNama
                NIM                              = $inputNim
                UAS                              = $inputUas
                UTS                              = $inputUts
                Tugas                           = $inputTugas
                Total                             = $total
                Rata-Rata Nilai           = $rataNilai
                Nilai Huruf                   = $nilaiHuruf
                Status                          = $status
            """.trimIndent()
            }
        }

        btnReset.setOnClickListener {

        }
    }
}