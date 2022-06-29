<?php 

require '../vendor/autoload.php';

use Dompdf\Dompdf;
use Dompdf\Options;

$options = new Options();
$options->set('isRemoteEnabled', true);
$options->set('isHtml5ParserEnabled', true);

$dompdf = new Dompdf($options);

$dompdf->setPaper('A4', 'portrait');

ob_start();
require('detail_pdf.php');
$html = ob_get_contents();
ob_clean();

$dompdf->loadHtml($html);
$dompdf->render();

$dompdf->stream('data-barang.pdf', ['Attachment' => false]);