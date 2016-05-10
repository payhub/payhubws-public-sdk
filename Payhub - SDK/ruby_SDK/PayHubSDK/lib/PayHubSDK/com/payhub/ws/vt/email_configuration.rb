class EmailConfiguration
  include JsonSerializer
  ATTRS=[:emailRbFailTransaction,:emailRbSuccessTransaction,:emailBatchFail,:emailBatchSuccess,:emailTrnReceipt,:emailExpPsw,:customBatchReport,:pdfOrCsvForBatch,:customRBReport,:pdfOrCsvForRB,:errors]
  EMAIL_LINK = "adminSettings/emailConfiguration"
  attr_accessor *ATTRS
  def initialize

  end

end