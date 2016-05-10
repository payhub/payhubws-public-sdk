class TransactionManager < WsConnections

  attr_reader :url,:token
  # TransactionManager constructor.
  # @param $_merchant
  # @param $_url
  # @param $_oauthToken
  def initialize(url,token,merchant)
    Util::validate_params(self.class.name, url,token,merchant)
    @url=url
    @token=token
    @merchant=merchant
  end


  #Perform a new Sale.
  #
  #@param sale object.
  #@return a SaleResponseInformation object.
  #@see {@link com.payhub.ws.api.SaleResponseInformation}
  def doSale(sale)
    sale.merchant=@merchant
    sale.url=@url
    sale.token=@token
    http,request = setHeadersPost(sale.url,@token)
    response = sale.doSale(http,request)
    return response
  end

  # Perform a new query that retrieves you the Sale Information for a particular Sale.
  #
  # @param String saleId: the ID of a particular Sale transaction.
  # @return a SaleResponseInformation object.
  # @see {@link com.payhub.ws.api.SaleResponseInformation}
  def getSaleInformation(saleId)
    if saleId.to_s=='' || saleId==nil
      return nil
    end
    url=@url+Sale::SALE_ID_LINK+saleId
    response=JSON.parse(doGet(url,@token))
    puts response.inspect
    result=SaleResponseInformation.new
    if not response.include?('errors')
      result=SaleResponseInformation.from_json(JSON.generate(response))
    else
      errors ||= Array.new
      response['errors'].each do |error|
        errors_aux=Errors.from_json(JSON.generate(error))
        errors.push(errors_aux)
      end
      result.errors=errors
    end
    return result
  end
  # Perform a new query that retrieves you the list of Sales Information.
  #
  # @return a SaleResponseInformation list object.
  # @see {@link com.payhub.ws.api.SaleResponseInformation}
  def getAllSalesInformation()
    url=@url+Sale::SALE_ID_LINK
    result=doGet(url,@token)
    return nil if result==nil or result==""
    result = JSON.parse(result)
    #convertir a array el result
    response ||= Array.new
    if result['errors']==nil
      result['_embedded']['sales'].each do |sales|
        response_tmp = SaleResponseInformation.from_json(JSON.generate(sales))#sales #SaleResponseInformation::fromArray(sales)
        response_tmp.transactionManager=self
        response.push(response_tmp)
      end
    else
      result['errors'].each do |error|
        response_tmp = Errors.from_json(JSON.generate(error))
        response.push(response_tmp)
      end
    end

    return response
  end

  # Perform a new Authorization.
  #
  # @param authorization object.
  # @return an AuthorizationResponseInformation object.
  # @see {@link com.payhub.ws.api.AuthorizationResponseInformation}
  def doAuthOnly(auth)
    auth.merchant=@merchant
    auth.url=@url
    auth.token=@token
    http,request = setHeadersPost(auth.url,@token)
    resposne = auth.doAuthOnly(http,request)
    response.transactionManager = self
    return resposne
  end

  # Perform a new query that retrieves you the Authorization Information for a particular Authorization.
  #
  # @param String authorizationId: the ID of a particular AuthorizationOnly transaction.
  # @return an AuthorizationResponseInformation object.
  # @see {@link com.payhub.ws.api.AuthorizationResponseInformation}
  def getAuthorizationInformation(authorizationId)
    if authorizationId.to_s=='' || authorizationId==nil
      return nil
    end
    url=@url+AuthOnly::AUTH_ID_LINK+authorizationId
    response=JSON.parse(doGet(url,@token))
    result=AuthorizationResponseInformation.new
    if not response.include?('errors')
      result=AuthorizationResponseInformation.from_json(JSON.generate(response))
    else
      errors ||= Array.new
      response['errors'].each do |error|
        errors_aux=Errors.from_json(JSON.generate(error))
        errors.push(errors_aux)
      end
      result.errors=errors
    end
    return result
  end
  #
  # Perform a new query that retrieves you the list of Authorizations Information.
  #
  # @return an AuthorizationResponseInformation list object.
  # @see {@link com.payhub.ws.api.AuthorizationResponseInformation}
  #
  def getAllAuthOnlyInformation()
    url=@url+AuthOnly::AUTH_ID_LINK
    result=doGet(url,@token)
    return nil if result==nil or result==""
    result = JSON.parse(result)
    response ||= Array.new
    if result['errors']==nil
      result['_embedded']['authonlys'].each do |authonlys|
        response_tmp = AuthorizationResponseInformation.from_json(JSON.generate(authonlys))
        response_tmp.transactionManager=self
        response.push(response_tmp)
      end
    else
      result['errors'].each do |error|
        response_tmp = Errors.from_json(JSON.generate(error))
        response.push(response_tmp)
      end
    end
    return response
  end
  # Perform a new CaptureResponse.
  #
  # @param capture object.
  # @return a LastCaptureResponseInformation object.
  # @see {@link com.payhub.ws.api.CaptureResponseInformation}
  def doCapture(capture)
    capture.merchant=@merchant
    capture.url=@url
    capture.token=@token
    http,request = setHeadersPost(capture.url,@token)
    response = capture.doCapture(http,request)
    response.transactionManager = self
    return response
  end

  # Perform a new query that retrieves you the Capture Information for a particular Capture.
  #
  # @param String captureId: the ID of a particular Capture.
  # @return a LastCaptureResponseInformation object.
  # @see {@link com.payhub.ws.api.CaptureResponseInformation}
  def getCaptureInformation(captureId)
    if captureId.to_s=='' || captureId==nil
      return nil
    end
    url=@url+Capture::CAPTURE_ID_LINK+captureId
    response=JSON.parse(doGet(url,@token))
    result=CaptureResponseInformation.new
    if not response.include?('errors')
      result=CaptureResponseInformation.from_json(JSON.generate(response))
    else
      errors ||= Array.new
      response['errors'].each do |error|
        errors_aux=Errors.from_json(JSON.generate(error))
        errors.push(errors_aux)
      end
      result.errors=errors
    end
    return result
  end
  #
  # Perform a new query that retrieves you the list of Captures Information.
  #
  # @return an LastCaptureResponseInformation list object.
  # @see {@link com.payhub.ws.api.CaptureResponseInformation}
  def getAllCaptureInformation()
    url=@url+Capture::CAPTURE_ID_LINK
    result=doGet(url,@token)
    return nil if result==nil or result==""
    result = JSON.parse(result)
    response ||= Array.new
    if result['errors']==nil
      result['_embedded']['captures'].each do |captures|
        response_tmp = CaptureResponseInformation.from_json(JSON.generate(captures))
        response_tmp.transactionManager=self
        response.push(response_tmp)
      end
    else
      result['errors'].each do |error|
        response_tmp = Errors.from_json(JSON.generate(error))
        response.push(response_tmp)
      end
    end
    return response
  end

  # Perform a new Void Transaction.
  #
  # @param VoidTransaction object.
  # @return a LastVoidResponseInformation object.
  # @see {@link com.payhub.ws.api.VoidResponseInformation}
  def  doVoid(void)
    void.merchant=@merchant
    void.url=@url
    void.token=@token
    http,request = setHeadersPost(void.url,@token)
    response = void.performVoidTransaction(http,request)
    response.transactionManager = self
    return response
  end

  # Perform a new query that retrieves you the Void Information for a particular Void Transaction.
  #
  # @param String voidId: the ID of a particular Void Transaction.
  # @return a LastVoidResponseInformation object.
  # @see {@link com.payhub.ws.api.VoidResponseInformation}
  def getVoidInformation(voidId)
    if voidId.to_s=='' || voidId==nil
      return nil
    end
    url=@url+VoidTransaction::VOID_ID_LINK+voidId
    response=JSON.parse(doGet(url,@token))
    result=VoidResponseInformation.new
    if not response.include?('errors')
      result=VoidResponseInformation.from_json(JSON.generate(response))
    else
      errors ||= Array.new
      response['errors'].each do |error|
        errors_aux=Errors.from_json(JSON.generate(error))
        errors.push(errors_aux)
      end
      result.errors=errors
    end
    return result

  end
  #
  # Perform a new query that retrieves you the list of Voids Information.
  #
  # @return an LastVoidResponseInformation list object.
  # @see {@link com.payhub.ws.api.VoidResponseInformation}
  #
  def getAllVoidInformation()
    url=@url+VoidTransaction::VOID_ID_LINK
    result=doGet(url,@token)
    return nil if result==nil or result==""
    result = JSON.parse(result)
    response ||= Array.new
    if result['errors']==nil
      result['_embedded']['voids'].each do |voids|
        response_tmp = VoidResponseInformation.from_json(JSON.generate(voids))
        response_tmp.transactionManager=self
        response.push(response_tmp)
      end
    else
      result['errors'].each do |error|
        response_tmp = Errors.from_json(JSON.generate(error))
        response.push(response_tmp)
      end
    end
    return response
  end
  # Perform a new Verify.
  #
  # @param Verify object.
  # @return a VerfyResponseInformation object.
  # @see {@link com.payhub.ws.api.VerfyResponseInformation}
  def doVerify(verify)
    verify.merchant=@merchant
    verify.url=@url
    verify.token=@token
    http,request = setHeadersPost(verify.url,@token)
    response = verify.performVerifyTransaction(http,request)
    response.transactionManager = self
    return response
  end

  # Perform a new query that retrieves you the Verify Information for a particular Verify Transaction.
  #
  # @param String verifyId: the ID of a particular Verify Transaction.
  # @return a VerfyResponseInformation object.
  # @see {@link com.payhub.ws.api.VerfyResponseInformation}
  def getVerifyInformation(verifyId)
    if verifyId.to_s=='' || verifyId==nil
      return nil
    end
    url=@url+Verify::VERIFY_ID_LINK+verifyId
    response=JSON.parse(doGet(url,@token))
    return nil if response==nil or response==""
    result=VerfyResponseInformation.new
    if not response.include?('errors')
      result=VerfyResponseInformation.from_json(JSON.generate(response))
    else
      errors ||= Array.new
      response['errors'].each do |error|
        errors_aux=Errors.from_json(JSON.generate(error))
        errors.push(errors_aux)
      end
      result.errors=errors
    end
    return result
  end
  #
  # Perform a new query that retrieves you the list of Verify Information.
  #
  # @return an VerfyResponseInformation list object.
  # @see {@link com.payhub.ws.api.VerfyResponseInformation}
  #
  def getAllVerifyInformation()
    url=@url+Verify::VERIFY_ID_LINK
    result=doGet(url,@token)
    return nil if result==nil or result==""
    result = JSON.parse(result)
    response ||= Array.new
    if result['errors']==nil
      result['_embedded']['verifications'].each do |verifications|
        response_tmp = VerfyResponseInformation.from_json(JSON.generate(verifications))
        response_tmp.transactionManager=self
        response.push(response_tmp)
      end
    else
      result['errors'].each do |error|
        response_tmp = Errors.from_json(JSON.generate(error))
        response.push(response_tmp)
      end
    end
    return response
  end

  # Perform a new Refund.
  #
  # @param Refund object.
  # @return a RefundInformation object.
  # @see {@link com.payhub.ws.api.RefundInformation}
  def doRefund(refund)
    refund.merchant=@merchant
    refund.url=@url
    refund.token=@token
    http,request = setHeadersPost(refund.url,@token)
    response = refund.performRefund(http,request)
    response.transactionManager = self
    return response
  end

  # Perform a new query that retrieves you the Refund Information for a particular Refund Operation.
  #
  # @param String refundId: the ID of a particular Refund Transaction.
  # @return a RefundInformation object.
  # @see {@link com.payhub.ws.api.RefundInformation}
  def getRefundInformation(refundId)
    if refundId.to_s=='' || refundId==nil
      return nil
    end
    url=@url+Refund::REFUND_ID_LINK+refundId
    response=JSON.parse(doGet(url,@token))
    return nil if response==nil or response==""
    result=RefundInformation.new
    if not response.include?('errors')
      result=RefundInformation.from_json(JSON.generate(response))
    else
      errors ||= Array.new
      response['errors'].each do |error|
        errors_aux=Errors.from_json(JSON.generate(error))
        errors.push(errors_aux)
      end
      result.errors=errors
    end
    return result
  end
  #
  # Perform a new query that retrieves you the list of Refund Information.
  #
  # @return an RefundInformation list object.
  # @see {@link com.payhub.ws.api.VerfyResponseInformation}
  #
  def getAllRefundInformation()
    url=@url+Refund::REFUND_ID_LINK
    result=doGet(url,@token)
    return nil if result==nil or result==""
    result = JSON.parse(result)
    response ||= Array.new
    if result['errors']==nil
      result['_embedded']['refunds'].each do |refunds|
        response_tmp = RefundInformation.from_json(JSON.generate(refunds))
        response_tmp.transactionManager=self
        response.push(response_tmp)
      end
    else
      result['errors'].each do |error|
        response_tmp = Errors.from_json(JSON.generate(error))
        response.push(response_tmp)
      end
    end
    return response
  end
  # Perform a new RecurringBilling.
  #
  # @param RecurringBill object.
  # @return a RecurringBillingInformation object.
  # @see {@link com.payhub.ws.api.RecurringBillResponseInformation}
  def doRecurringBill(recurringBill)
    recurringBill.merchant=@merchant
    recurringBill.url=@url
    recurringBill.token=@token
    http,request = setHeadersPost(recurringBill.url,@token)
    response = recurringBill.performRecurringBill(http,request)
    response.transactionManager = self
    return response
  end

  # Perform a new query that retrieves you the Recurring Bill Information for a particular Recurring Bill transaction.
  #
  # @param String recurringBillId: the ID of a particular Recurring Bill Transaction.
  # @return a RecurringBillingInformation object.
  # @see {@link com.payhub.ws.api.RecurringBillResponseInformation}
  def getRecurringBillInformation(recurringBillId)
    if recurringBillId.to_s=='' || recurringBillId==nil
      return nil
    end
    url=@url+RecurringBill::RECURRENT_BILL_ID_LINK+recurringBillId
    response=JSON.parse(doGet(url,@token))
    return nil if response==nil or response==""
    result=RecurringBillResponseInformation.new
    if not response.include?('errors')
      result=RecurringBillResponseInformation.from_json(JSON.generate(response))
      response.transactionManager = self
    else
      errors ||= Array.new
      response['errors'].each do |error|
        errors_aux=Errors.from_json(JSON.generate(error))
        errors.push(errors_aux)
      end
      result.errors=errors
    end
    return result
  end
  #
  # Perform a new query that retrieves you the list of bills for sales Information.
  #
  # @return an BillInformation list object.
  # @see {@link com.payhub.ws.api.BillInformation}
  #
  def getAllBillForSalesInformation()
    url=@url+"bill-for-sale/"
    result=doGet(url,@token)
    return nil if result==nil or result==""
    result = JSON.parse(result)
    response ||= Array.new
    if result['errors']==nil
      result['_embedded']['billforsale'].each do |billforsale|
        json=JSON.generate(billforsale)
        response_tmp = BillInformation.from_json(json)
        response_tmp.bill=Bill.from_json(json)
        response_tmp.transactionManager=self
        response.push(response_tmp)
      end
    else
      result['errors'].each do |error|
        response_tmp = Errors.from_json(JSON.generate(error))
        response.push(response_tmp)
      end
    end
    return response
  end
  #
  # Perform a new query that retrieves you the list of bills for recurring bills Information.
  #
  # @return an BillInformation list object.
  # @see {@link com.payhub.ws.api.BillInformation}
  #
  def getAllBillForRecurringBillInformation()
    url=@url+"bill-for-recurring-bill/"
    result=doGet(url,@token)
    return nil if result==nil or result==""
    result = JSON.parse(result)
    response ||= Array.new
    if result['errors']==nil
      result['_embedded']['billsforrecurringbill'].each do |billsforrecurringbill|
        json=JSON.generate(billsforrecurringbill)
        response_tmp = BillInformation.from_json(json)
        response_tmp.bill=Bill.from_json(json)
        response_tmp.transactionManager=self
        response.push(response_tmp)
      end
    else
      result['errors'].each do |error|
        response_tmp = Errors.from_json(JSON.generate(error))
        response.push(response_tmp)
      end
    end
    return response
  end
  #
  # Perform a new query that retrieves you the list of Merchants.
  #
  # @return an MerchantInformation list object.
  # @see {@link com.payhub.ws.api.MerchantInformation}
  #
  def getAllMerchantInformation()
    url=@url+"merchant/"
    result=doGet(url,@token)
    return nil if result==nil or result==""
    result = JSON.parse(result)
    response ||= Array.new
    if result['errors']==nil
      result['_embedded']['merchants'].each do |merchants|
        json=JSON.generate(merchants)
        response_tmp = MerchantInformation.from_json(json)
        response_tmp.merchant=Merchant.from_json(json)
        response_tmp.transactionManager=self
        response.push(response_tmp)
      end
    else
      result['errors'].each do |error|
        response_tmp = Errors.from_json(JSON.generate(error))
        response.push(response_tmp)
      end
    end
    return response
  end
  #
  # Perform a new query that retrieves you the list of Card Data.
  #
  # @return an CardDataInformation list object.
  # @see {@link com.payhub.ws.api.CardDataInformation}
  #
  def getAllCardDataInformation()
    url=@url+"carddata/"
    result=doGet(url,@token)
    return nil if result==nil or result==""
    result = JSON.parse(result)
    response ||= Array.new
    if result['errors']==nil
      result['_embedded']['carddata'].each do |carddata|
        json=JSON.generate(carddata)
        response_tmp = CardDataInformation.from_json(json)
        response_tmp.cardData=CardData.from_json(json)
        response_tmp.transactionManager=self
        response.push(response_tmp)
      end
    else
      result['errors'].each do |error|
        response_tmp = Errors.from_json(JSON.generate(error))
        response.push(response_tmp)
      end
    end
    return response
  end
  #
  # Perform a new query that retrieves you the list of Customers for sales.
  #
  # @return an CustomerInformation list object.
  # @see {@link com.payhub.ws.api.CustomerInformation}
  #/
  def getAllCustomerForSalesInformation()
    url=@url+"customer-for-sale/"
    result=doGet(url,@token)
    return nil if result==nil or result==""
    result = JSON.parse(result)
    response ||= Array.new
    if result['errors']==nil
      result['_embedded']['customerforsale'].each do |customerforsale|
        json=JSON.generate(customerforsale)
        response_tmp = CustomerInformation.from_json(json)
        response_tmp.customer=Customer.from_json(json)
        response_tmp.transactionManager=self
        response.push(response_tmp)
      end
    else
      result['errors'].each do |error|
        response_tmp = Errors.from_json(JSON.generate(error))
        response.push(response_tmp)
      end
    end
    return response
  end
  #
  # Perform a new query that retrieves you the list of Customers for Recurring billings.
  #
  # @return an CustomerInformation list object.
  # @see {@link com.payhub.ws.api.CustomerInformation}
  #
  def getAllCustomerForRecurringBillInformation()
    url=@url+"customer/"
    result=doGet(url,@token)
    return nil if result==nil or result==""
    result = JSON.parse(result)
    response ||= Array.new
    if result['errors']==nil
      result['_embedded']['customers'].each do |customers|
        json=JSON.generate(customers)
        response_tmp = CustomerInformation.from_json(json)
        response_tmp.customer=Customer.from_json(json)
        response_tmp.transactionManager=self
        response.push(response_tmp)
      end
    else
      result['errors'].each do |error|
        response_tmp = Errors.from_json(JSON.generate(error))
        response.push(response_tmp)
      end
    end
    return response
  end

  #
  # Perform a new query that retrieves you the Recurring Bill Information from a Customer Id.
  #
  # @param String customerId: the ID of a particular Customer.
  # @return a RecurringBillingInformation object.
  # @see {@link com.payhub.ws.api.RecurringBillResponseInformation}
  #
  def findRecurringBillInformationByCustomer(customerId)
    url=@url+RecurringBill::RECURRENT_BILL_ID_LINK+"search/findByCustomerRef?customerId="+customerId
    result=doGet(url,@token)
    return nil if result==nil or result==""
    result = JSON.parse(result)
    response ||= Array.new
    puts result

    if not (result.include?('errors') or result.include?('error') or result.include?('cause') or result.include?('message'))
      result['_embedded']['recurring-bills'].each do |recurringBill|
        json=JSON.generate(recurringBill)
        response_tmp = RecurringBillResponseInformation.from_json(json)
        response_tmp.transactionManager=self
        response.push(response_tmp)
      end
    else
      response_tmp = Errors.from_json(JSON.generate(result))
      response.push(response_tmp)
    end

    return response
  end

  def updateRecurringBillStatus(recurringBillId)
    if recurringBillId.to_s=='' || recurringBillId==nil
      return false
    end
    url=@url+"recurring-bill-status/"+recurringBillId.to_s
    http,request = setHeadersPatch(url,@token)
    informationToSend = {"recurring_bill_status"=>"CANCELED"}
    request.body = JSON.generate(informationToSend)
    result=doPatch(http,request)
    if result==true
      return true
    else
      response = JSON.parse(result)
      errors ||= Array.new
      response['errors'].each do |error|
        errors_aux=Errors.from_json(JSON.generate(error))
        errors.push(errors_aux)
      end
      return errors
    end
  end

  def updateRecurringBill(recurringBillId,recurringBill)
    if recurringBillId.to_s=='' || recurringBillId==nil
      return false
    end
    url=@url+"recurring-bill/"+recurringBillId.to_s
    http,request = setHeadersPatch(url,@token)
    informationToSend = recurringBill.serialize_to_json
    request.body = informationToSend
    result=doPatch(http,request)
    if result==true
      return true
    else
      response = JSON.parse(result)
      errors ||= Array.new
      response['errors'].each do |error|
        errors_aux=Errors.from_json(JSON.generate(error))
        errors.push(errors_aux)
      end
      return errors

    end
  end

  def findTransactions(parameters)
    url=@url+"report/transactionReport/"
    http,request = setHeadersPost(url,@token)
    transactionReports=findTransactionReports(http,request,parameters)
    return nil if transactionReports==nil or transactionReports==""
    transactionReports=JSON.parse(transactionReports)

    response ||= Array.new
    if not transactionReports.include?('errors')
      transactionReports.each do |transactionReport|
        response_aux=TransactionReportInformation.from_json(JSON.generate(transactionReport))
        response.push(response_aux)
      end
    else
      transactionReports['errors'].each do |error|
        response_tmp = Errors.from_json(JSON.generate(error))
        response.push(response_tmp)
      end
    end
    if transactionReports.include?('error')
      response_tmp = Errors.from_json(JSON.generate(transactionReports))
      response.push(response_tmp)
    end
    return response
  end

  # @param [Object] datos
  # @param [Object] type
  # @param [Object] operationId
  def addMetaData(datos, type, operationId)
    metadataUrl=nil
    if TransactionType::Sale==type
      metadataUrl=url+"metadata/forSale/"+operationId
    elsif TransactionType::AuthOnly==type
      metadataUrl=url+"metadata/forAuthOnly/"+operationId
    elsif TransactionType::Capture==type
      metadataUrl=url+"metadata/forCapture/"+operationId
    elsif TransactionType::Bill==type
      metadataUrl=url+"metadata/forBill/"+operationId
    elsif TransactionType::CardData==type
      metadataUrl=url+"metadata/forCardData/"+operationId
    elsif TransactionType::Customer==type
      metadataUrl=url+"metadata/forCustomer/"+operationId
    elsif TransactionType::Merchant==type
      metadataUrl=url+"metadata/forMerchant/"+operationId
    elsif TransactionType::RecurringBill==type
      metadataUrl=url+"metadata/forRecurringBill/"+operationId
    elsif TransactionType::Schedule==type
      metadataUrl=url+"metadata/forSchedule/"+operationId
    elsif TransactionType::Refund==type
      metadataUrl=url+"metadata/forRefund/"+operationId
    elsif TransactionType::VoidTransaction==type
      metadataUrl=url+"metadata/forVoid/"+operationId
    end
    http,request = setHeadersPut(metadataUrl,@token)
    request.body=datos
    result=doPut(http,request)
    if result.body.to_s==''
      return true
    else
      return result.body
    end

  end

  def getGeneralSettings()
    url=@url+GeneralSettings::GENERAL_SETTINGS_LINK
    result=doGet(url,@token)
    return nil if result==nil or result==""
    result = JSON.parse(result)
    response = GeneralSettings.new
    tlist = Array.new
    if result['errors']==nil
      response = GeneralSettings.from_json(JSON.generate(result))
      result['terminalList'].each do |terminalList|
        json=JSON.generate(terminalList)
        response_tmp = TerminalList.from_json(json)
        tlist.push(response_tmp)
      end
      response.terminalList=tlist
      return response
    else
      elist = Array.new
      result['errors'].each do |errors|
        json=JSON.generate(errors)
        response_tmp = Errors.from_json(json)
        elist.push(response_tmp)
      end
      response.errors = elist
      return response
    end
  end

  def getWebhookConfiguration()
    url=@url+WebhookConfiguration::WEBHOOK_LINK
    result=doGet(url,@token)
    return nil if result==nil or result==""
    result = JSON.parse(result)
    response = WebhookConfiguration.new
    if result['errors']==nil
      response = WebhookConfiguration.from_json(JSON.generate(result["webhookConfiguration"]))
      return response
    else
      elist = Array.new
      result['errors'].each do |errors|
        json=JSON.generate(errors)
        response_tmp = Errors.from_json(json)
        elist.push(response_tmp)
      end
      response.errors = elist
      return response
    end
  end


  def getValidatedDevices()
    url=@url+ValidatedDevices::VALIDATED_DEVICES_LINK
    result=doGet(url,@token)
    return nil if result==nil or result==""
    result = JSON.parse(result)
    response = ValidatedDevices.new
    devTmp=Array.new
    if result['errors']==nil
      response.enforce_device_validation = result['enforce_device_validation']
      result['devices'].each do |devices|
        json=JSON.generate(devices)
        response_tmp = Devices.from_json(json)
        devTmp.push(response_tmp)
      end
      response.devices=devTmp
      return response
    else
      elist = Array.new
      result['errors'].each do |errors|
        json=JSON.generate(errors)
        response_tmp = Errors.from_json(json)
        elist.push(response_tmp)
      end
      response.errors = elist
      return response
    end
  end

  def getRiskFraudSettings()
    url=@url+RiskFraudSettings::RISK_FRAUD_SETTINGS_LINK
    result=doGet(url,@token)
    return nil if result==nil or result==""
    result = JSON.parse(result)
    response = RiskFraudSettings.new
    devTmp=Array.new
    if result['errors']==nil
      response = RiskFraudSettings.from_json(JSON.generate(result))
      return response
    else
      elist = Array.new
      result['errors'].each do |errors|
        json=JSON.generate(errors)
        response_tmp = Errors.from_json(json)
        elist.push(response_tmp)
      end
      response.errors = elist
      return response
    end
  end

  def patchWebhookConfiguration(webhook)
    url=@url+WebhookConfiguration::WEBHOOK_LINK
    http,request = setHeadersPatch(url,@token)
    json = webhook.serialize_to_json
    request.body = json
    result=doPatch(http,request)
    if result==true
      return true
    else
      response = JSON.parse(result)
      errors ||= Array.new
      response['errors'].each do |error|
        errors_aux=Errors.from_json(JSON.generate(error))
        errors.push(errors_aux)
      end
      return errors
    end

  end

  def patchValidatedDevices(vd)
    url=@url+ValidatedDevices::VALIDATED_DEVICES_LINK
    http,request = setHeadersPatch(url,@token)
    vd.devices=nil
    json = vd.serialize_to_json
    request.body = json
    result=doPatch(http,request)
    if result==true
      return true
    else
      response = JSON.parse(result)
      errors ||= Array.new
      response['errors'].each do |error|
        errors_aux=Errors.from_json(JSON.generate(error))
        errors.push(errors_aux)
      end
      return errors
    end
  end

  def patchRiskFraudSettings(risk)
    url=@url+RiskFraudSettings::RISK_FRAUD_PATCH_SETTINGS_LINK
    http,request = setHeadersPatch(url,@token)
    json = risk.serialize_to_json
    request.body = json
    result=doPatch(http,request)
    if result==true
      return true
    else
      response = JSON.parse(result)
      errors ||= Array.new
      response['errors'].each do |error|
        errors_aux=Errors.from_json(JSON.generate(error))
        errors.push(errors_aux)
      end
      return errors
    end
  end

  def getAllUserRoles()
    url = @url+UserRole::ALL_USER_ROLE_LINK;
    result=doGet(url,@token)
    return nil if result==nil or result==""
    result = JSON.parse(result)
    response = UserRole.new
    role_tmp=Array.new
    if result['errors']==nil
      result['userRoles'].each do |userRoles|
        json=JSON.generate(userRoles)
        response_tmp = Roles.from_json(json)
        role_tmp.push(response_tmp)
      end
      response.userRoles=role_tmp
      return response
    else
      elist = Array.new
      result['errors'].each do |errors|
        json=JSON.generate(errors)
        response_tmp = Errors.from_json(json)
        elist.push(response_tmp)
      end
      response.errors = elist
      return response
    end
  end

  def getUserRolesById(roleId)
    if roleId.to_s=='' || roleId==nil
      return nil
    end
    url=@url+RoleSettings::USER_ROLE_LINK+roleId
    result=doGet(url,@token)
    return nil if result==nil or result==""
    result = JSON.parse(result)
    response = RoleSettings.new
    if result['errors']==nil
      response = RoleSettings.from_json(JSON.generate(result))
      return response
    else
      elist = Array.new
      result['errors'].each do |errors|
        json=JSON.generate(errors)
        response_tmp = Errors.from_json(json)
        elist.push(response_tmp)
      end
      response.errors = elist
      return response
    end
  end

  def patchUserRoles(roleSettings,roleId)
    url=@url+RoleSettings::PATCH_USER_ROLE_LINK+roleId
    http,request = setHeadersPatch(url,@token)
    json = roleSettings.serialize_to_json
    request.body = json
    result=doPatch(http,request)
    if result==true
      return true
    else
      response = JSON.parse(result)
      errors ||= Array.new
      response['errors'].each do |error|
        errors_aux=Errors.from_json(JSON.generate(error))
        errors.push(errors_aux)
      end
      return errors
    end
  end

  def postUserRoles(role)
    url=@url+RoleSettings::CREATE_USER_ROLE_LINK
    http,request = setHeadersPost(url,@token)
    json = role.serialize_to_json
    request.body = json
    result=doPostForRoles(http,request)
    if result.body.to_s==''
      return true
    else
      return result.body
    end
  end

  def getEmailConfiguration()
    url=@url+EmailConfiguration::EMAIL_LINK
    result=doGet(url,@token)
    return nil if result==nil or result==""
    result = JSON.parse(result)
    response = EmailConfiguration.new
    if result['errors']==nil
      response = EmailConfiguration.from_json(JSON.generate(result["emailConfiguration"]))
      return response
    else
      elist = Array.new
      result['errors'].each do |errors|
        json=JSON.generate(errors)
        response_tmp = Errors.from_json(json)
        elist.push(response_tmp)
      end
      response.errors = elist
      return response
    end
  end

  def patchEmailConfiguration(emailConfig)
    url=@url+EmailConfiguration::EMAIL_LINK
    http,request = setHeadersPatch(url,@token)
    json = emailConfig.serialize_to_json
    request.body = json
    result=doPatch(http,request)
    if result==true
      return true
    else
      response = JSON.parse(result)
      errors ||= Array.new
      response['errors'].each do |error|
        errors_aux=Errors.from_json(JSON.generate(error))
        errors.push(errors_aux)
      end
      return errors
    end

  end
end