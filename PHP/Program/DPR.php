<?php
    class DPR{
        private $id = '';
        private $nama = '';
        private $bidang = '';
        private $partai = '';
        private $foto = '';

        public function __construct($id = '', $nama = '', $bidang = '', $partai = '', $foto = '') {
            $this->id = $id;
            $this->nama = $nama;
            $this->bidang = $bidang;
            $this->partai = $partai;
            $this->foto = $foto;
        }

        public function setId($id){
            $this->id = $id;
        }

        public function getId() {
            return $this->id;
        }

        public function setNama($nama){
            $this->nama = $nama;
        }

        public function getNama() {
            return $this->nama;
        }

        public function setBidang($bidang){
            $this->bidang = $bidang;
        }

        public function getBidang() {
            return $this->bidang;
        }

        public function setPartai($partai){
            $this->partai = $partai;
        }

        public function getPartai() {
            return $this->partai;
        }

        public function setFoto($foto){
            $this->foto = $foto;
        }

        public function getFoto() {
            return $this->foto;
        }
    }
?>