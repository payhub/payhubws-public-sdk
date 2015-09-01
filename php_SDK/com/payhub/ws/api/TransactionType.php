<?php

/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 24/07/2015
 * Time: 09:11
 */
class TransactionType
{
    const Sale="forSale";
    const AuthOnly="forAuthOnly";
    const Capture="forCapture";
    const Bill="forBill";
    const CardData="forCardData";
    const Customer="forCustomer";
    const Merchant="forMerchant";
    const RecurringBill="forRecurringBill";
    const Schedule="forSchedule";
    const Refund="forRefund";
    const VoidTransaction="forVoid";
    const Verify="forVerify";
}