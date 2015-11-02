class NotificationsController < ApplicationController
  def homepage
    puts 'algo'
  end

  def add

   valores = params[:notification]
   file = File.open("some_file.txt", "w+")
   file.write(valores)
  rescue IOError => e
    #some error occur, dir not writable etc.
  ensure
    file.close unless file.nil?
  end

  def getNotifications
    file =File.open("some_file.txt", 'r') {|f| f.read() }
    @my_array=nil
    @my_array = file

  end
end
