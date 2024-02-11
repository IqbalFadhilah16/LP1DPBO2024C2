<?php
    require('DPR.php');

    $anggota = array();  // Daftar anggota DPR
    
    function create($anggota, $id, $nama, $bidang, $partai, $foto) {
        $dpr = new DPR($id, $nama, $bidang, $partai, $foto);
        array_push($anggota, $dpr);
        return $anggota;
    }

    function read($anggota) {
        echo "<table border='1'>";
        echo "<h2 style='margin-left:40px'>DATA ANGGOTA DPR</h2>";
        echo "<tr><th>ID</th><th>Nama</th><th>Bidang</th><th>Partai</th><th>Foto</th></tr>";
        foreach ($anggota as $dpr) {
            echo "<tr>";
            echo "<td style='text-align: center;'>" . $dpr->getId() . "</td>";
            echo "<td style='text-align: center;'>" . $dpr->getNama() . "</td>";
            echo "<td style='text-align: center;'>" . $dpr->getBidang() . "</td>";
            echo "<td style='text-align: center;'>" . $dpr->getPartai() . "</td>";
            echo "<td><img src='" . $dpr->getFoto() . "'width='100'></td>";  // Tambahkan width='150' di sini
            echo "</tr>";
        }
        echo "</table>";
    }

    function update($anggota, $id, $nama, $bidang, $partai, $foto) {
        foreach ($anggota as $dpr) {
            if ($dpr->getId() == $id) {
                $dpr->setNama($nama);
                $dpr->setBidang($bidang);
                $dpr->setPartai($partai);
                $dpr->setFoto($foto);
            }
        }
        return $anggota;
    }

    function delete($anggota, $id) {
        foreach ($anggota as $key => $dpr) {
            if ($dpr->getId() == $id) {
                unset($anggota[$key]);
            }
        }
        return $anggota;
    }

    // Contoh penggunaan fungsi
    $anggota = create($anggota, 1, 'Iqbal', 'Hukum', 'PKS', 'img\marsha.jpg');
    $anggota = create($anggota, 2, 'Iqbal Fadhilah', 'Pertahanan', 'PDI', 'img\marsha.jpg');
    
    read($anggota);
    echo "Data berhasil diinput!";
    echo "<br><br>";
    $anggota = update($anggota, 1, 'Muhammad Iqbal', 'IT', 'PKS', 'img\marsha.jpg');
    read($anggota);
    echo "Data berhasil diubah!";
    echo "<br><br>";
    $anggota = delete($anggota, 2);
    read($anggota);
    echo "Data berhasil dihapus!";
    echo "<br><br>";
?>
